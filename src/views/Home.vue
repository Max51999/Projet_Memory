<template>
  <div class="home">
    <Bienvenue msg="Bienvenue sur MyMultichat-Game !!!"/>
    <Login />
  </div>
</template>

<script>
// @ is an alias to /src
import Bienvenue from '@/components/Bienvenue.vue'
import Login from '@/components/Login.vue'

export default {
  name: 'Home',
  components: {
    Login,
    Bienvenue
  }
}
</script>

