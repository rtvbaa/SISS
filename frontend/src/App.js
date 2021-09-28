import "./App.css";
import {useEffect, useState} from 'react';
import ProductTable from './ProductTable'
import Header from './Header.js';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

function App() {
    const handleClick = () => {
        console.log("POST");
        sendPost();
    };


    // const array = useState(defaultItems);
    // const items = array[0];
    // const setItems = array[1];
    const [items, setItems] = useState([]);

    // hook
    useEffect(() => {
        getData().then(data => {
            setItems(data);
        })
    }, [setItems]);

    return (
        <div className="App">
            <Router>
                <header className="App-header"><Header/></header>
                <Switch>
                    <Route exact path="/">
                        <body className="App-body">
                        <div className="container">
                            <ProductTable items={items}/>
                        </div>

                        <div>
                            <button id="the-button" onClick={handleClick}>
                                Add a new product
                            </button>
                        </div>
                        </body>
                    </Route>
                    <Route path="/Sale">
                        <body className="App-body">
                            <p>Sale</p>
                        </body>
                    </Route>
                    <Route path="/Discount">
                        <body className="App-body">
                        <p>Discount</p>
                        </body>
                    </Route>
                </Switch>

            </Router>





        </div>
    );
}

function getData() {
    return fetch("http://localhost:8080/get").then((res) => {
        return res.json();
    });
}


function sendPost() {
    let payload = {
        id: document.getElementById('NewIDProduct').value,
        productName: document.getElementById('NewProductName').value,
        productPrice: document.getElementById('NewProductPrice').value
    };

    fetch("http://localhost:8080/post",
        {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(payload)
        })
        .then(function (res) {
            return res.json();
        })
        .then(() => {
            window.location.reload();
        })
}

export default App;
