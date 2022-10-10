<template>

  <div class="jb-box">
    <video muted autoplay loop>
      <source src="@/assets/video/music.mp4" type="video/mp4">
      <strong>Your browser does not support the video tag.</strong>
    </video>
    <div class="jb-text">
      <h1>Sound Cloud</h1>
      <section class="py-5 text-center container">
        <h1 class="fw-light">Get Starting Now</h1>
        <p class="py-5">
          <router-link to="/test4">
          <a href="#" class="btn btn-primary my-2">환영합니다!</a>
          </router-link>
        </p>
      </section>
    </div>
  </div>  
</template>

<script>
export default {


};


</script>



<style scoped>

.jb-box {
  width: 100%;
  height: 100%;
  overflow: hidden;
  margin: 0px auto;
  position: relative;
}

video {
  width: 100%;
  height: 50%;
}

.jb-text {
  position: absolute;
  top: 35%;
  width: 100%;
}

.jb-text p {
  margin-top: -24px;
  text-align: center;
  font-size: 48px;
  color: #ffffff;
}

.jb-text h1 {
  margin-top: -24px;
  text-align: center;
  font-size: 48px;
  color: #ffffff;
}

.jb-text p {
  margin-top: -24px;
  text-align: center;
  font-size: 48px;
  color: #ffffff;
}

</style>