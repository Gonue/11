<template>
    <main class="form-signin w-100 m-auto">


        <h1 class="h3 mb-3 fw-normal">회원가입 페이지</h1>

        <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com"
                v-model="state.form.email">
            <label for="floatingInput">Email address</label>
        </div>
        <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com"
                v-model="state.form.name">
            <label for="floatingInput">Name</label>
        </div>
       
        <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com"
                v-model="state.form.password">
            <label for="floatingInput">Password</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password"
                v-model="state.form.password">
            <label for="floatingPassword">Password-Check</label>
        </div>
        
        

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" @click="submit()">Sign in</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>

    </main>
</template>


<script>

import { reactive } from "vue";
import axios from 'axios';
import store from '@/scripts/store';
import router from '@/scripts/router';

export default {
    setup() {
        const state = reactive({
            form: {
                email: "",
                password: "",
            }
        })

        const submit = () => {
            
                router.push({ path: "/" });
                window.alert("회원가입 성공.");
            }
            
        
        return { state, submit }
    }
}
</script>

<style scoped>
.form-signin {
    max-width: 330px;
    padding: 15px;
}

.form-signin .form-floating:focus-within {
    z-index: 2;
}

.form-signin input[type="email"] {
    margin-bottom: -1px;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
</style>
