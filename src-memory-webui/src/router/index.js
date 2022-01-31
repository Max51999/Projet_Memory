import { createRouter, createWebHashHistory } from 'vue-router'
//import Home from '../views/Home.vue'
import Login from '@/components/Login.vue'
import Maison from '@/components/Maison.vue'
import Lechat from '@/components/Lechat.vue'
import Lejeu from '@/components/jeu/LeJeu.vue'

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  { path: '/maison/:lenom',
    name: 'Maison',
    component: Maison 
  },
  { path: '/maison/:lenom/chat',
    name: 'Lechat',
    component: Lechat 
  },
  { path: '/maison/:lenom/jeu',
  name: 'Lejeu',
  component: Lejeu
  },  
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
