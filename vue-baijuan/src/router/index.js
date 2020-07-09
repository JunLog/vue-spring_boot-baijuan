import Vue from "vue";
import VueRouter from "vue-router";
// import Home from "../views/Home.vue";

import AppIndex from "../components/home/Appindex";
import Login from "../components/Login";
import Home from "../components/Home";

Vue.use(VueRouter);

const routes = [
  {
    path: "/home",
    name: "Home",
    component: Home,
    redirect: "/index",
    children: [
      {
        path: "/index",
        name: "AppIndex",
        component: AppIndex,
        meta: {
          requireAuth: true,
        },
      },
    ],
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
];

const router = new VueRouter({
  mode: "history",
  routes,
});

export default router;
