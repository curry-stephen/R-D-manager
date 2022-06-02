import {createRouter, createWebHistory} from 'vue-router'
import Layout from '../layout/LayOut.vue'
import Login from '../views/Login.vue'

const routes = [
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect: "/webhome",
        children: [
            {
                path: 'owinfo',
                name: 'Owinfo',
                component: () => import("../views/Owinfo.vue"),
            },
            {
                path: 'matter',
                name: 'Matter',
                component: () => import("../views/Matter.vue"),
            },
            {
                path: 'inspect',
                name: 'Inspect',
                component: () => import("../views/Inspect.vue"),
            },
            {
                path: 'sale',
                name: 'Sale',
                component: () => import("../views/Sale.vue"),
            },
            {
                path: 'rgoods',
                name: 'Rgoods',
                component: () => import("../views/Rgoods.vue"),
            },
            {
                path: 'druginfo',
                name: 'Druginfo',
                component: () => import("../views/Druginfo.vue"),
            },
            {
                path: 'supplyinfo',
                name: 'Supplyinfo',
                component: () => import("../views/Supplyinfo.vue"),
            },
            {
                path: 'tosupply',
                name: 'Tosupply',
                component: () => import("../views/Tosupply.vue"),
            },
            {
                path: 'bill',
                name: 'Bill',
                component: () => import("../views/Bill.vue"),
            },
            {
                path: 'updatepwd',
                name: 'Updatepwd',
                component: () => import("../views/Updatepwd.vue"),
            },
            {
                path: 'usermapper',
                name: 'UserMapper',
                component: () => import("../views/UserMapper.vue"),
            }

        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import("../views/Login.vue"),
    },
    // {
    //     path: '/index',
    //     name: 'Index',
    //     component: () => import("../views/Index.vue"),
    // },
    {
        path:'/webhome',
        name:'WebHome',
        component:()=>import("../menhuview/WebHome.vue")
    },
    {
        path:'/dongtai',
        name:'DongtaiAbout',
        component:()=>import("../menhuview/DongtaiAbout.vue")
    },
    {
        path:'/drugandfu',
        name:'DrugAndFu',
        component:()=>import("../menhuview/DrugAndFu.vue")
    },
    {
        path:'/datacenter',
        name:'DataCenter',
        component:()=>import("../menhuview/DataCenter.vue")
    },
    {
        path:'/item',
        name:'Zhexian',
        component:()=>import("../menhucomponets/MyFuwu.vue")
    }

    
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
