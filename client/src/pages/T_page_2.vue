<template>
<div class="test-player-wrap">
  <vue3-video-player @global-auto-play="autoPlay" :src="source2" title="Smartisan T1"
  :barrageConfig="{fontSize: 20, opacity: 90, position: 80, barrageList: barrages2}" :view-core="viewCore">
  </vue3-video-player>
</div>
</template>

<script>

export default {
  setup() {
  }
}
</script>



<style scoped>
</style>