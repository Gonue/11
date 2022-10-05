<template>
    상품 자세히

    <body>
        <main class="mt-3">
            <div class="container">
                <div class="row">
                    <div class="col-md-5">
                        <div id="carouselExampleIndicators" class="carousel carousel-dark slide"
                            data-bs-ride="carousel">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                                    class="active" aria-current="true" aria-label="Slide 1"></button>
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                                    aria-label="Slide 2"></button>
                            </div>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="data:image/jpeg;base64,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"
                                        class="d-block w-100" id="img1" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img src="data:image/jpeg;base64,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"
                                        class="d-block w-100" id="img1" alt="...">
                                </div>

                            </div>
                            <button class="carousel-control-prev" type="button"
                                data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button"
                                data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">고양이</h5>
                                <h5 class="card-title pt-3 pb-3 border-top">원</h5>
                                <p class="card-text pt-3 pb-3 border-top">
                                    <!-- <span class="badge bg-warning">신제품</span> -->

                                </p>
                                <p class="card-text pb-3">
                                    고양이 ㅋㅋ
                                </p>
                                <div class="border-top">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                    <label class="form-check-label" for="defaultCheck1">
                                        1
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                    <label class="form-check-label" for="defaultCheck1">
                                        2
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                    <label class="form-check-label" for="defaultCheck1">
                                        3
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                    <label class="form-check-label" for="defaultCheck1">
                                        4
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                    <label class="form-check-label" for="defaultCheck1">
                                        5
                                    </label>
                                </div>
                            </div>
                            <div class="card-text pt-3 pb-3 border-top">
                                <div class="row">
                                    <div class="col-auto">
                                        <label class="col-from-label">구매수량</label>
                                    </div>
                                    <div class="col-auto">
                                        <div class="input-group">
                                            <span class="input-group-text">-</span>
                                            <input type="text" class="form-control" style="width:40px;" value="1">
                                            <span class="input-group-text">+</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row pt-3 pb-3 border-top">
                                <div class="col-6">
                                    <h3>총 상품 금액</h3>
                                </div>
                                <div class="col-6" style="text-align: right;">
                                    <h3>0원</h3>
                                </div>
                            </div>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="col-6 d-grid p-1">
                                    <button type="button" class="btn btn-lg btn-secondary btn-dark ">장바구니</button>
                                </div>
                                <div class="col-6 d-grid p-1">
                                    <button type="button" class="btn btn-lg btn-secondary btn-warning">주문하기</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </main>
    </body>
</template>
<script>


export default {


}
</script>

<style scoped>
#img1{
    width: 600px;
    height: 600px;
}
</style>