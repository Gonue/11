import Home from "@/pages/Home";
import Login from "@/pages/Login";
import Cart from "@/pages/Cart";
import Order from "@/pages/Order";
import Register from "@/pages/Register"
import { createRouter, createWebHistory } from "vue-router";
import Product_detail from "@/pages/Product_detail"
import Product_create from "@/pages/Product_create"
import Product_delete from "@/pages/Product_delete"
import Member_chat from "@/pages/Member_chat"
import Admin from "@/pages/Admin"
import Member_chat_test from "@/pages/Member_chat_test"
import T_page from "@/pages/T_page"


const routes = [
    { path: "/", component: Home },
    { path: "/login", component: Login },
    { path: "/cart", component: Cart},
    { path: "/order", component: Order},
    { path: "/register", component: Register},
    { path: "/detail", component: Product_detail},
    { path: "/create", component: Product_create},
    { path: "/delete", component: Product_delete},
    { path: "/admin", component: Admin},
    { path: "/chat", component: Member_chat},
    { path: "/chat1", component: Member_chat_test},
    { path: "/test", component: T_page},


  ];
  
  const router = createRouter({
    history: createWebHistory(),
    routes,
  });

  export default router;