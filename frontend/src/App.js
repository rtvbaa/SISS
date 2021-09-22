import "./App.css";
import {useEffect, useState} from 'react';
import ProductTable from './ProductTable'

const defaultItems = [{id: '1', productName: 'name', productPrice: 23}];

function App() {
    const handleClick = () => {
        console.log("POST");
        sendPost();
    };


    // const array = useState(defaultItems);
    // const items = array[0];
    // const setItems = array[1];
    const [items, setItems] =  useState(defaultItems);

            // hook
    useEffect(()=>{
        getData().then(data => {
            setItems(data);
        })
    });

    return (
        <div className="App">
            <header className="App-header">
                <div className="container">
                    <ProductTable items={items}/>
                </div>
                <div>
                    <button id="the-button" onClick={handleClick}>
                        Add a new product
                    </button>
                </div>
            </header>
        </div>
    );
}

function getData() {
 return fetch("http://localhost:8080/get").then((res) => {return res.json();});
}


function sendPost() {
    let payload = {
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
