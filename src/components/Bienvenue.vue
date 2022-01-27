<template>
  <div id='titre'>
    <h2>Bienvenue {{ msg }}</h2>
  </div>
  <div id='navigation'>
    <nav><h4>
      <Navigation v-if="!$route.params.lenom==''" :url="homeurl" desc="Maison "/>

      <Navigation v-if="!$route.params.lenom==''" :url="chaturl" desc="Discutons !! "/>

      <Navigation v-if="!$route.params.lenom==''" :url="jeuurl" desc="Jouons !! "/>

      <Navigation v-if="!$route.params.lenom==''" :url="byeurl" desc="Au revoir... " @click="effaceTout"/>


      </h4>
    </nav>
  </div>
  <div id='login' v-if="$route.params.lenom == null">
    <login @loginEvent="setUser"/>
  </div>
  <div id='contenu' v-else>
    <router-view />
  </div>
</template>

<script>

import Login from '@/components/Login.vue'
import Navigation from '@/components/Navigation.vue'


export default {
  name: 'Bienvenue',
  components : {
    Login,
    Navigation
  },
  data(){
    return {
      message : '',
      homeurl: '',
      byeurl: '',

    }
  },
  props: {
    msg: String
  },
  created(){
    if (this.$store.getters.getLeUser == ''){
      this.message = this.msg;
    }
  },
  methods:{
    setUser(){
      this.message = this.$store.getters.getLeUser
      this.homeurl = '/maison/' + this.$store.getters.getLeUser
    },
    effaceTout(){

    }
  }
}
</script>