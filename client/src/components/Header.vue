<template>
  <header>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">


      <div class="container-fluid">
        <router-link to="/start" class="navbar-brand">Logo</router-link>


        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="collapsibleNavbar">
          <ul class="navbar-nav">
            <li class="nav-item">
              <router-link to="/" class="nav-link">Home</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/admin" class="nav-link">Admin</router-link>
            </li>
            <li class="nav-item" v-if="$store.state.account.id">
              <router-link to="/chat" class="nav-link">Community</router-link>
            </li>
            <li class="nav-item" v-if="$store.state.account.id">
              <router-link to="/orders" class="nav-link">주문내역</router-link>
            </li>
          </ul>
          <ul class="navbar-nav">

            <router-link to="/like" class="nav-link btn like">
              <i class="fa fa-heart" aria-hidden="true"></i>
            </router-link>

            <router-link to="/cart" class="nav-link btn cart">
              <i class="fa fa-shopping-cart" aria-hidden="true"></i>
            </router-link>

            <li class="nav-item">
              <router-link to="/register" class="nav-link" v-if="!$store.state.account.id">Register</router-link>
            </li>
            
            <li class="nav-item">
              <router-link to="/login" class="nav-link" v-if="!$store.state.account.id">Login</router-link>
              <a to="/login" class="nav-link" @click="logout()" v-else>LogOut</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

  </header>
</template>

<script>
import store from "@/scripts/store";
import router from "@/scripts/router";
import axios from "axios";
export default {
  name: 'Header',
  setup() {
    const logout = () => {
      axios.post("/api/account/logout").then(() => {
        store.commit('setAccount', 0);
        router.push({ path: "/" });
      });
    }
    return { logout }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
header ul li a {
  cursor: pointer;
}
header .navbar .like {
  color: red;
}

header .navbar .cart {
  color: yellow;
}
</style>
