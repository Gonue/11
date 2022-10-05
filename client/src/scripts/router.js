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
    { path: "/Chat", component: Member_chat},


  ];
  
  const router = createRouter({
    history: createWebHistory(),
    routes,
  });

  export default router;