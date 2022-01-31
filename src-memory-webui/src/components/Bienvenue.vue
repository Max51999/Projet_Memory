<template>
<div id='titre'>
  <h2> Bienvenue {{ message }}</h2> 
</div>
<div id='Navig'>
        <nav><h4>
            <navigation v-if="!$route.params.lenom ==''" :url="homeurl" desc="Maison " /> 
            <span v-if="!$route.params.lenom ==''"> - </span>
            <navigation v-if="!$route.params.lenom ==''" :url="jeuurl" desc="Jouons !!" />
            <span v-if="!$route.params.lenom ==''"> - </span>
            <navigation v-if="!$route.params.lenom ==''" :url="byeurl" desc="Au revoir ... (sniff)" @click="effaceTout" />
        </h4></nav>
    </div>

<div id='Log' v-if="$route.params.lenom == null">
    <login @loginEvent="setUser"/>
</div>  
<div id='contenu' v-else>
     <router-view />    
</div>
</template>

<script>
import Login from '@/components/Login.vue'
import Navigation from './Navigation.vue'

export default {
    name : 'Bienvenue',
    components : {
        Login,
        Navigation
    },
    data(){
        return {
            message : '',
            homeurl : '/',
            chaturl : '',
            jeuurl : '',
            byeurl:'/'
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
            this.chaturl = '/maison/' + this.$store.getters.getLeUser + '/chat'
            this.jeuurl = '/maison/' + this.$store.getters.getLeUser + '/jeu'
        },
        effaceTout(){
            sessionStorage.clear();
            this.message = this.msg;
            this.homeurl = '/'
        },
    }
}
</script>
