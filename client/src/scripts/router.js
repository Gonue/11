import Home from "@/pages/Home";
import Login from "@/pages/Login";
import Cart from "@/pages/Cart";
import Order from "@/pages/Order";
import Register from "@/pages/Register"
import { createRouter, createWebHistory } from "vue-router";
import Product_detail from "@/pages/Product_detail"

const routes = [
    { path: "/", component: Home },
    { path: "/login", component: Login },
    { path: "/cart", component: Cart},
    { path: "/order", component: Order},
    { path: "/register", component: Register},
    { path: "/product_d", component: Product_detail},

  ];
  
  const router = createRouter({
    history: createWebHistory(),
    routes,
  });

  export default router;