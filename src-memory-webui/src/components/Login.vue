<template>
  <div class="LoginForm">
    <form id="app" @submit="checkForm">
      <h5>
        <p v-if="errors.length">
        <b>Corriger vos erreurs ... : </b>
        <ul style="list-style-type: none;">
          <li v-for="error in errors" :key="error">{{ error }}</li>
        </ul>
        </p>
      </h5>
      <p>
      <label for="nom">Nom : </label>
      <input
        id="nom"
        name="nom"
        type="text"
        v-model="nom">
      </p>
      <p>
      <label for="prenom">Prénom : </label>
      <input
        id="prenom"
        name="prenom"
        type="text"
        v-model="prenom">
      </p>
      <p>
      <label for="pseudo">Pseudo : </label>
      <input
        id="pseudo"
        name="pseudo"
        type="text"
        v-model="pseudo">
      </p>
      <p>
      <label for="mail">Email : </label>
      <input
        id="mail"
        name="mail"
        type="text"
        v-model="mail">
      </p>
      <p>
      <input
        type="submit"
        value="Go !!">
      </p>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      errors: [],
      nom: null,
      prenom: null,
      pseudo: null,
      mail: null,
    };
  },
  methods: {
    checkForm: function (e) {
      if (this.nom && this.prenom && this.pseudo && this.mail && this.checkEmail(this.mail)) {
        this.$store.commit("setLeNom", this.nom)
        this.$store.commit("setLePrenom", this.prenom)
        this.$store.commit("setLePseudo", this.pseudo);
        this.$store.commit("setLeMail", this.mail);
        this.$emit("loginEvent");
        this.$router.push({ name: "Maison", params: { lenom: this.nom } });
      }
      if (!this.nom) {
        this.errors.push("Nom obligatoire.");
      }
      if (!this.prenom) {
        this.errors.push("Prénom obligatoire.");
      }
      if (!this.pseudo) {
        this.errors.push("Pseudo obligatoire.");
      }
      if (!this.mail) {
        this.errors.push("Mail obligatoire.");
      }
      if (!this.checkEmail(this.mail)) {
        this.errors.push("Mail invalide.");
      }
      e.preventDefault();
    },
    checkEmail(email) {
             var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
             return re.test(email);
         }
  },
};
</script>