import { createStore } from 'vuex'

export default createStore({
  state: {
    lenom : '',
    leprenom: '',
    lepseudo: '',
    lemail: '',
  },
  getters: {
    getLeUser(state){
      return state.lepseudo;
    }
  },
  mutations: {
    setLeNom(state,nom) {
      state.lenom = nom;
    },
    setLePrenom(state,prenom) {
      state.leprenom = prenom;
    },
    setLeMail(state,mail) {
      state.lemail = mail;
    },
    setLePseudo(state,pseudo) {
      state.lepseudo = pseudo;
    },
  },
  actions: {
  },
  modules: {
  }
})
