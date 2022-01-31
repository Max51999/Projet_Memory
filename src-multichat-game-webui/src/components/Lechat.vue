<template>
  <table id="liste-chat">
    <thead>
      <tr>
        <th>N° <td>{{ chatReponse.canalId }}</td></th>
        <th>Description <td>{{ chatReponse.canalName }}</td></th>
      </tr>
    </thead>
    <tbody v-if="this.chatReponse.canalId == ''">
      <tr v-for="row in this.leschat" :key="row">
        <td>{{ row.canalId }}</td>
        <td>{{ row.canalName }}</td>
      </tr>
    </tbody>
  </table>
  <div v-if="this.serverUrl == ''">
    <button v-for="row in this.leschat" :key="row" @click="chatConnect(row.canalId)">Canal {{ row.canalId }}</button>
  </div>
  <div v-if="this.serverUrl !=''">
    <div>
      <span><pre>{{ chatAllMessage }}</pre></span>
    </div>
    <input v-model="reponse" style="width:300px"/>
    <button @click="sendReponse">répondre ...</button>
    <p>
    <button @click="chatBye">ByeBye ...</button>
    </p>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {

    ws : null,
    serverUrl: "",
      leschat: {
        canalId: "",
        canalName: "",
      },
      reponse : '',
      chatMessage: {
        canalId: 0,
        lePseudo: "",
        leContenu: "",
      },
      chatReponse: {
        canalId: "",
        lePseudo: "",
        leContenu: "",
        canalName: "",
      },
      chatAllMessage: "",
    };
  },
  mounted() {
    console.log("Appel service Rest ...")
    axios.get("http://localhost:8080/services/multichat/").then((response) => {
      this.leschat = response.data;
      console.log(this.leschat)
    });
  },
  methods: {
    handleNewMessage(event) {
      
        console.log(event.data);
        this.chatMessage = JSON.parse(event.data);
        
        if(this.chatMessage.lePseudo != this.chatReponse.lePseudo & this.chatMessage.canalId == this.chatMessage.canalId) {
          this.chatAllMessage = this.chatAllMessage + this.chatMessage.lePseudo + " : " + this.chatMessage.leContenu + "\n";
        }
        
    },
    chatBye(){
        console.log("On est déconnecté !!!");
        this.ws.close();
        this.ws = null;
        this.chatAllMessage='';
        this.chatReponse.canalId = "";
        this.chatReponse.canalName = "";
        this.serverUrl = "";

    },
    sendReponse(){
      
      this.chatReponse.lePseudo = this.$store.getters.getLeUser;
      this.chatReponse.leContenu = this.reponse; 
      this.ws.send(JSON.stringify(this.chatReponse)); 
      this.reponse = '';
    },
    chatConnect(i) {     
      if (this.serverUrl != "") {
        this.chatBye(); 
      }
      console.log("Starting connection to WebSocket Server");
      this.serverUrl = "ws://localhost:8080/ws/multichat/" + i + ":" + this.$store.getters.getLeUser;
      this.ws = new WebSocket( this.serverUrl );
      this.ws.onopen = function (event) {
        console.log(event);
        console.log("On est connecté !!!");
      };
      this.ws.addEventListener('message', (event) => { this.handleNewMessage(event) });
      this.chatReponse.canalId = i;
      this.chatReponse.canalName = this.leschat[i-1].canalName;
    }
  },
};
</script>