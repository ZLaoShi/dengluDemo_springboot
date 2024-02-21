import axios from "axios";
import {ElMessage} from "element-plus";

const authItemName = "access_token"

const defaultFailure = (message, code, url) => {
    console.warn(`请求地址：${url}, 状态码:${code}, 错误信息:${message}`)
    ElMessage.warning(message)
}

function takeAccessToken() { //拿到Token
    const str = localStorage.getItem(authItemName) || sessionStorage.getItem(authItemName)
    if(!str) return null;
    const authObj = JSON.parse(str)
    if(authObj.expire <= new Date()) {
        deleteAccessToken()
        ElMessage.warning(`登录状态已过期，请重新登录`)
        return null
    }
    return authObj.token
}

function storeAccessToken(remember, token, expire) { //存储Token
    const authObj = {token: token, expire: expire}
    const str = JSON.stringify(authObj)
    if(remember)
        localStorage.setItem(authItemName, str)
    else
        sessionStorage.setItem(authItemName, str)
}

function deleteAccessToken() { //删除Token
    localStorage.removeItem(authItemName)
    sessionStorage.removeItem(authItemName)
}
const defaultError = (err) => {
    console.error(err)
    ElMessage.warning('发生了一些错误,请联系管理员')
}

function accessHeader() {
    const token = takeAccessToken();
    return token ? {'Authorization':`Bearer ${takeAccessToken()}`} : {}
}

function get(url, success, failure = defaultFailure) {
    internalGet(url, accessHeader(), success, failure)
}

function post(url, data, success, failure = defaultFailure) {
    internalPost(url, data, accessHeader(), success, failure)
}
function internalPost(url, data, header, success, failure) {
    axios.post(url, data, {headers:header}).then(({data}) => {
        if(data.code === 200) {
            success(data.data)
        } else {
            failure(data.message, data.code, url)
        }
    } ).catch(err => console.log(err))
}

function internalGet(url, header, success, failure, error) {
    axios.get(url, {headers:header}).then(({data}) => {
        if(data.code === 200) {
            success(data.data)
        } else {
            failure(data.message, data.code, url)
        }
    } ).catch(err => error(err))
}

function login(username, password, remember, success, failure = defaultFailure) {
    internalPost('/api/auth/login', {
        username:username,
        password:password
    }, {
        'Content-Type' : 'application/x-www-form-urlencoded'
    },
        (data) => {
        storeAccessToken(remember, data.token, data.expire)
        ElMessage.success(`登录成功，欢迎 ${data.username} 来到我们的系统`)
            success(data)
        },failure)
}

function logout(success, failure = defaultFailure) {
    get('/api/auth/logout', () => {
        deleteAccessToken()
        ElMessage.success('退出登录成功')
        success()
    }, failure)
}

function unauthorized() {
    return !takeAccessToken()
}
export {login, logout, get, post, unauthorized}