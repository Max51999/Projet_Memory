<template>
    <button @click="clickMe">
        <img :src="require('@/assets' +  imageurl)" />
        
    </button>
</template>

<script>
const urlrond = '/img/rond.png'
const urlcroix = '/img/croix.png'
const urlvide = '/img/vide.png'
export default {
    props: {
        image : String,
        id : String
    },
    computed: {
        imageurl: function(){
            if (this.image == '') {
                //this.affichage = false;
                return urlvide;
            } else {
                //this.affichage = true;
                if (this.image == 'croix') {
                    return urlcroix; 
                }
                if (this.image == 'rond') {
                    return urlrond; 
                }
                return '';
            }
        }
    },
    methods: {
        clickMe(){
            this.$emit('clickCase',this.id);
        }
    }
}
</script>