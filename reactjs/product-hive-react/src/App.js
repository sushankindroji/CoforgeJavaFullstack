import React, { useState, useEffect} from "react";
import './App.css';
import logo from './logo.svg';
//import { BrowserRouter as Router,Routes,Route,Navigate } from 'react-router-dom';
import { BrowserRouter as Router,Routes,Route } from 'react-router-dom';

import HomePage from './components/HomePage';
import ViewProduct from './components/ViewProduct';
import Login from './components/Login';
import NavBar1 from './components/NavBar1';
import Product from './components/Product';
import DealerRegistration from './components/DealerRegistration';
import CreateProduct from './components/CreateProduct';
import Logout from './components/Logout';


/*
	React Router is a standard library for routing in React. 
	It enables the navigation among views of various components in a React Application, 
  allows changing the browser URL, and keeps the UI in sync with the URL. 

	React Router is a JavaScript framework that lets us handle client and server-side 
  routing in React applications. 
  It enables the creation of single-page web or mobile apps that allow navigating without 
  refreshing the page. 
  It also allows us to use browser history features while preserving the right application
   view.

   Used Version6 of Router

 // npm install react-router-dom@6
*/


/*To use the Font-awesome, install all given packages from npm into your app.

npm i --save @fortawesome/fontawesome-svg-core
npm i --save @fortawesome/free-solid-svg-icons
npm i --save @fortawesome/react-fontawesome

 * And import the library for the font-awesome

*/
import { library } from '@fortawesome/fontawesome-svg-core';
import { faTrash,faEdit,faList,faHome,faSignIn,faSignOut,faCameraRetro,faBomb,faCoffee,faPeopleGroup,faSearch } from '@fortawesome/free-solid-svg-icons';
import About from './components/About';
import DealerInfo from './components/DealerInfo';
import ProductSearch from './components/ProductSearch';


library.add(faTrash,faEdit,faList,faHome,faSignIn,faSignOut,faCameraRetro,faBomb,faCoffee,faPeopleGroup,faSearch);

function App() {
   
   return ( <>
   
    <div className="App">
     
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
       <h1>ProductHive</h1>
      </header>

      <section>
        <div style={{ backgroundImage: "url(/images/pms2.webp)",
                    backgroundRepeat: 'no-repeat',
                    backgroundSize:'cover', minHeight:'140vh',minWidth:'95vw'}}> 
       
         <Router>
              <NavBar1/> 
                          
            <Routes>
              <Route path='/' element={<HomePage/>} />                                        
             
              <Route path='/register' element={<DealerRegistration/>} />
              <Route path='/login' element={<Login/>} />
              <Route path='/aboutus' element={<About/>}/>

              <Route path="/product" element={<Product/>}/>
              <Route path="/search" element={<ProductSearch/>}/>
             <Route path="/logout" element={<Logout/>}/>
             <Route path="/dealers" element={<DealerInfo/>}/>
               
              <Route path='/viewProduct/:id' element={<ViewProduct/>}/>
              <Route path='/addProduct/:id' element={<CreateProduct/>} />  
                
            </Routes>
           </Router>
           
        </div>
      </section>

       <footer className='footer'>
        <p>&copy; All Right Reserved to Wipro Bengaluru</p>
      </footer> 
    </div>
    </>
  );
};



export default App;
