import React,{useState,useEffect} from "react";
import { useNavigate } from 'react-router-dom';

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import ProductService from "../service/ProductService";
import AuthenticationService from "../service/AuthenticationService";
/*
    The useNavigate() hook is introduced in the React Router v6 
    to replace the useHistory() hook.
    the React Router’s new navigation API provides a useNavigate() 
    hook which is an imperative version to perform the navigation actions 
    with better compatibility. 

    The useNavigate hook lets you navigate programmatically within your React code.
*/
function Product() {

    const history = useNavigate();
 

    // state Management using useState() react Hook
    const [products, setProducts] = useState([]);
    const [message, setMessage] = useState('');
    const [user,setUser] =useState('');

    /*
    The useEffect hook in React is use to handle the side effects in React such as 
    fetching data, and updating DOM. This hook runs on every render but there is 
    also a way of using a dependency array using which we can control the effect of 
    rendering.

    The motivation behind the introduction of useEffect Hook is to eliminate the 
    side effects of using class-based components.

    Syntax: useEffect(<FUNCTION>, <DEPENDECY>)
     - To run useEffect on every render do not pass any dependency
     - To run useEffect only once on the first render pass any empty array in the dependecy
     - To run useEffect on change of a particular value. Pass the state and props in the dependency array
     */

    // handling componentDidMount()
    useEffect(() => { // reactHook - Runs only once on the first Render
      
       if(!AuthenticationService.isUserLoggedIn()){
        history('/login');
       }else{
        fetchProducts();
        setUser(AuthenticationService.getLoggedInUserName());
    }
    }, [history]);

    const fetchProducts = () => {
        ProductService.getProducts().then((response) => {
            setProducts(response.data); // setting response to state
        })
        .catch((error) => {
            console.log("Error:"+ error.message)});       
    };

    const addProduct = () => {
        history('/addProduct/_add'); // Load Component createproduct and pass '_add' as parameter
    };

    const editProduct = (id) => {
        history(`/addProduct/${id}`); // use back Quote operator
    };

    const deleteProduct = (id) => {
        ProductService.deleteProduct(id).then(() => {
           // setProducts(products.filter(product => product.id !== id));
           fetchProducts(); // Refresh products list
            setMessage('Product deleted successfully.'); 
             // Clear the message after 2 seconds
             setTimeout(() => {
                setMessage('');
            }, 2000);
        });
    };

    const viewProduct = (id) => {
        history(`/viewProduct/${id}`);
    };
   /*
    We are using the map operator to loop over our products list and create the view
    */
            return(
            <div>
              
                {/* <div className="container">Welcome {user}</div> */}
                <h1 className="text-warning">Products List</h1>
                
                    <div className = "row justify-content-center">
                        <button className="btn btn-info w-auto" onClick={addProduct}>Add Product</button>
                    </div>
                <br/>
                <div className="row justify-content-center" >
                    <table className="table table-success w-auto">
                     <thead>
                        <tr className="table-danger">
                            <th> Product Id</th>
                            <th> Product Name</th>
                            <th> Brand</th>
                            <th> MadeIn</th>
                            <th> Price</th>
                            <th> Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                            {products.map(
                                    prod => 
                                    <tr key={prod.id}>
                                        <td> {prod.pid} </td>
                                        <td> {prod.name} </td>
                                        <td> {prod.brand} </td>
                                        <td> {prod.madein} </td>
                                        <td> {prod.price} </td>
                                        <td>
                                        <button className="btn btn-success" onClick={() => editProduct(prod.pid)}>
                                                <span>
                                                  <FontAwesomeIcon icon="edit"></FontAwesomeIcon>
                                                </span> 
                                           </button>
                                           &nbsp;
                                            <button className="btn btn-danger" onClick={() => deleteProduct(prod.pid)}>
                                               <span>
                                                  <FontAwesomeIcon icon="trash"></FontAwesomeIcon>
                                                </span> 
                                         </button>
                                          &nbsp;
                                           <button className="btn btn-primary" onClick={() => viewProduct(prod.pid)}>
                                                 <span>
                                                  <FontAwesomeIcon icon="list"></FontAwesomeIcon>
                                                </span> 
                                           </button>
                                        </td> 
                                    </tr>
                                )
                            }
                    </tbody>
                    </table>
                </div>
                {message && <div className="alert alert-success">{message}</div>}
            </div>
        )
    }


export default Product;