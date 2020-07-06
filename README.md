# vue-spring_boot-baijuan

VUE + Spring Boot 前后端分离 白卷 White-Jotter

### 创建前端项目

前提是安装了 VUE Cli

vue ui

- 进入*Vue 项目管理器* （没有的话，左上角下拉点击）
- 创建 创建新项目
- 瞎几把配置了一下，我也不知道，随缘吧，不行再说
- 创建完成后，点击左菜单栏 任务
- serve -> 运行 -> 启动 app
- 出现 vue 标志的页面就是成功创建了

#### vue 项目目录结构

- build 项目构建文件夹(webpack) 暂时还没有
- config 配置目录，端口号等 暂时还没有 现在的版本没这个文件夹了？
- node_modules 项目依赖
- public
- src 开发目录
- static 静态资源
- inde.html 入口文件
- package.json 项目依赖配置文件

App.vue

```javaScript
<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </div>
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

```

一个 vue 文件包括 `<template>` `<script>` `<style>`三组标签

`<script>` 标签里的 `export default` 是 ES6 语法，意思是将这个组件导出，之后用 `import` 导入这个组件就可以

`<template>` 标签组里的 `<router-view/>` 是路由容器(路由视图)，有其他的内容填充到这个位置，具体的路由定义在 router 文件夹的 index.js 文件里定义

index.html 与 App.vue 建立关联是通过 main.js 文件建立的

因为 Vue 项目默认是 8080 端口，Spring Boot 默认端口也是 8080，所以同时运行会发生冲突

##### 修改 Vue 的端口

Vue 3.x 中修改端口号则需要在项目根目录下创建一个 vue.config.js ，内容如下。

```javascript
module.exports = {
  devServer: {
    port: 8088, // 端口号
  },
};
```

在开发的时候，前端用前端的服务器（Nginx），后端用后端的服务器（Tomcat），当我开发前端内容的时候，可以把前端的请求通过前端服务器转发给后端（称为反向代理）

正向代理就是，你要访问一个网站，比如“谷弟弟”，然后发现访问不到，于是你访问了一个能访问到“谷弟弟”的代理服务器，让它帮你拿到你想浏览的页面。

反向代理就是，你访问了一个网站，你以为它是“谷弟弟”，但其实它是“谷姐”，“谷姐”知道你其实是想找她弟，就取回“谷弟弟”的内容给你看。作为用户的你，是不知道有这个过程的，这么做是为了保护服务器，不暴露服务器的真实地址

设置反向代理

```javaScript
import Vue from 'vue'
import App from './App'
import router from './router'
// 设置反向代理，前端请求默认发送到 http://localhost:8443/api
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
```

前端请求用到了 axios 模块
在 vue ui 中安装依赖

### 后端项目创建

使用 IDEA 的 Spring Initializr 创建
![LoginController](/images/LoginController.png)
