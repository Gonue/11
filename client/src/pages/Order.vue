<template>
    <div class="container">
        <main>
            <div class="py-5 text-center">
                <h2>주문페이지</h2>
            </div>
            <div class="row g-5">
                <div class="col-md-5 col-lg-4 order-md-last">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-primary">장바구니</span>
                        <span class="badge bg-primary rounded-pill">{{state.items.length}}</span>
                    </h4>
                    <ul class="list-group mb-3">
                        <li class="list-group-item d-flex justify-content-between lh-sm" v-for="(i,idx) in state.items"
                            :key="idx">
                            <div>
                                <h6 class="my-0">{{i.name}}</h6>
                                <small class="text-muted">{{i.write}}</small>
                            </div>
                            <span class="text-muted">${{lib.getNumberFormatted(i.price)}}</span>
                        </li>

                        <li class="list-group-item d-flex justify-content-between">
                            <span>Total(USD)</span>
                            <strong>${{lib.getNumberFormatted(computedPrice)}}</strong>
                        </li>
                    </ul>
                </div>
                <div class="col-md-7 col-lg-8">
                    <h4 class="mb-3">주문자 정보</h4>
                    <div class="needs-validation" novalidate="">
                        <div class="row g-3">
                            <div class="col-12"><label for="username" class="form-label">이름</label>
                                <div class="input-group has-validation">
                                    <input type="text" class="form-control" id="username" placeholder="Username" 
                                    v-model="state.form.name">
                                </div>
                            </div>
                            <div class="col-12"><label for="address" class="form-label">주소</label>
                                <input type="text"
                                    class="form-control" 
                                    id="address" 
                                    placeholder="1234 Main St" 
                                    v-model="state.form.address">
                            </div>
                        </div>
                        <hr class="my-4">
                        <h4 class="mb-3">결제수단</h4>
                        <div class="my-3">
                            <div class="form-check"><input id="card" name="paymentMethod" type="radio"
                                    class="form-check-input" value="card" v-model="state.form.payment"><label class="form-check-label"
                                    for="card">신용카드</label></div>
                            <div class="form-check"><input id="bank" name="paymentMethod" type="radio" value="bank"
                                    class="form-check-input" v-model="state.form.payment"><label class="form-check-label" for="bank">무통장
                                    입금</label></div>

                            <!-- <div class="form-check"><input id="paypal" name="paymentMethod" type="radio"
                                    class="form-check-input" required=""><label class="form-check-label"
                                    for="paypal">PayPal</label></div> -->
                        </div>
                        <div class="row gy-3">
                            <div class="col-md-6"><label for="cc-name" class="form-label">카드 번호</label><input
                                    type="text" class="form-control" id="cc-name" v-model="state.form.cardNumber"><small
                                    class="text-muted">Full name as displayed on card</small>
                                <div class="invalid-feedback"> Name on card is required </div>
                            </div>
                            <div class="col-md-6"><label for="cc-number" class="form-label">Credit card
                                    number</label><input type="text" class="form-control" id="cc-number" placeholder=""
                                    required="">
                                <div class="invalid-feedback"> Credit card number is required </div>
                            </div>
                        </div>
                        <hr class="my-4">
                        <button class="w-100 btn btn-primary btn-lg" @click="submit()">결제하기</button>
                        </div>
                </div>
            </div>
        </main>
    </div>
    <div class="py-5"></div>
    <div class="py-5"></div>

</template>


<script>
import { computed, reactive } from "vue";
import axios from 'axios';
import lib from "@/scripts/lib";
import router from "@/scripts/router";


export default {
    setup() {
        const state = reactive({
            items: [],
            form: {
                name: "",
                address: "",
                payment: "",
                cardNumber: "",
                items: "",
            }
        })



        const load = () => {
            axios.get("/api/cart/items").then(({ data }) => {
                console.log(data);
                state.items = data;
            })
        };

        const submit = () => {
            const args = JSON.parse(JSON.stringify(state.form));
            args.items = JSON.stringify(state.items);

            axios.post("/api/orders", args).then(() => {
                console.log('submit성공');
                alert('주문이 성공적으로 처리되었습니다.');
                router.push({path:"/orders"})
            })
        }

        const computedPrice = computed(() => {
            let result = 0;
            for (let i of state.items) {
                result += i.price;
            }
            return result;
        });
        load();
        return { state, lib, computedPrice, submit }
    }
}
</script>

<style scoped>

</style>