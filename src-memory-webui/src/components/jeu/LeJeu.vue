<template>
  <div>
    <table>
      <tr v-for="colonnes in plateau.colonne" :key="colonnes">
        <th v-for="cases in colonnes" :key="cases.id">
          <Lacase 
            :id=cases.id
            :image=cases.image
            @clickCase="traiteClick"
          />
        </th>
      <!--  <th>
          <Lacase
            :id="plateau.case[1].id"
            :image="plateau.case[1].image"
            @clickCase="traiteClick"
          />
        </th> -->
      </tr>
    </table>
  </div>
</template>

<script>
import Lacase from "@/components/jeu/LaCase.vue";
export default {
  components: {
    Lacase,
  },
  data() {
    return {
      plateau: {
        colonne: {        
          ligne1: [
            { id: "1", image: "", state: 0 },
            { id: "2", image: "", state: 0 },
            { id: "3", image: "", state: 0 },
          ],
          ligne2: [
            { id: "4", image: "", state: 0 },
            { id: "5", image: "", state: 0 },
            { id: "6", image: "", state: 0 },
          ],
          ligne3: [
            { id: "7", image: "", state: 0 },
            { id: "8", image: "", state: 0 },
            { id: "9", image: "", state: 0 },
          ],
        }
      }
    }
  },
  methods: {
    traiteClick(idcase) {
      console.log("Case clicquée :" + idcase);

      Object.keys(this.plateau.colonne).forEach((ligne) => {
        Object.keys(this.plateau.colonne[ligne]).forEach((cse) => {
          if (idcase == this.plateau.colonne[ligne][cse].id) {
          switch (this.plateau.colonne[ligne][cse].state) {
            case 0:
              this.plateau.colonne[ligne][cse].state = 1;
              this.plateau.colonne[ligne][cse].image = "rond";
              break;
            case 1:
              this.plateau.colonne[ligne][cse].state = 2;
              this.plateau.colonne[ligne][cse].image = "croix";
              break;
            case 2:
              this.plateau.colonne[ligne][cse].state = 0;
              this.plateau.colonne[ligne][cse].image = "";
          }
        }
      });});
    },
  },
};
</script>