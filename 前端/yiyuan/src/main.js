import {createApp} from 'vue'
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
// import Search from "@element-plus/icons-vue";
import 'default-passive-events'
import * as ELIcons from '@element-plus/icons-vue'
createApp(App).use(store).use(router).use(ElementPlus, {locale: zhCn})
.use(ELIcons)
.mount('#app')
