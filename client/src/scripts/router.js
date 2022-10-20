import Home from "@/pages/Home";
import Login from "@/pages/Login";
import Cart from "@/pages/Cart";
import Like from "@/pages/Like";
import Order from "@/pages/Order";
import Register from "@/pages/Register";
import { createRouter, createWebHistory } from "vue-router";
import Product_detail from "@/pages/Product_detail";
import Product_create from "@/pages/Product_create";
import Product_delete from "@/pages/Product_delete";
import Member_chat from "@/pages/Member_chat";
import Admin from "@/pages/Admin";
import Member_chat_test from "@/pages/Member_chat_test";
import T_page from "@/pages/T_page";
import T_page_2 from "@/pages/T_page_2";
import T_page_3 from "@/pages/T_page_3";
import T_page_4 from "@/pages/T_page_4";
import T_page_5 from "@/pages/T_page_5";
import T_page_6 from "@/pages/T_page_6";

import NotFoundPage from "@/pages/NotFoundPage";
import Orders from "@/pages/Orders";


const routes = [
  { path: "/", component: T_page_4 },

  { path: "/login", component: Login },
  { path: "/cart", component: Cart },
  { path: "/like", component: Like },
  { path: "/order", component: Order },
  { path: "/register", component: Register },
  { path: "/detail", component: Product_detail },
  { path: "/create", component: Product_create },
  { path: "/delete", component: Product_delete },
  { path: "/admin", component: Admin },
  { path: "/chat", component: Member_chat },
  { path: "/chat1", component: Member_chat_test },

  { path: "/test", component: T_page },

  { path: "/test2", component: T_page_2 },

  { name:"start", path: "/start", component: T_page_3 },

  { path: "/test4", component: Home },

  { path: "/test5", component: T_page_5 },

  { path: "/test6", component: T_page_6 },


  { path: "/404", component: NotFoundPage },

  { path: "/:pathMatch(.*)*", redirect: "/404" },
  { path: "/orders", component: Orders },


];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
