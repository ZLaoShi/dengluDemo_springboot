// import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router";
import axios from "axios";
import 'element-plus/theme-chalk/dark/css-vars.css'

axios.defaults.baseURL = 'http://localhost:1145'

const app = createApp(App)

app.use(router)

app.mount('#app')
