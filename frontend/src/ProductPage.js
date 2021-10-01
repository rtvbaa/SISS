import {useEffect, useState} from 'react';
import ProductTable from './ProductTable'

function ProductPage() {

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

    return(
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
    )

    function getData() {
        return fetch("http://localhost:8080//getProduct").then((res) => {
            return res.json();
        });
    }

    function sendPost() {
        let payload = {
            id: document.getElementById('NewIDProduct').value,
            productName: document.getElementById('NewProductName').value,
            productPrice: document.getElementById('NewProductPrice').value
        };

        fetch("http://localhost:8080/postProduct",
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

}

export default ProductPage;