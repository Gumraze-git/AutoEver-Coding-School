// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getStorage } from "firebase/storage";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyD5e8AKbCRxXxWlYSYNyLpdm75jZfXgKF0",
  authDomain: "autoever-vue-project.firebaseapp.com",
  projectId: "autoever-vue-project",
  storageBucket: "autoever-vue-project.firebasestorage.app",
  messagingSenderId: "915835033770",
  appId: "1:915835033770:web:992aecb24ea4733ae958d3",
  measurementId: "G-5LYDQG0GD8",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
export const storage = getStorage(app);
