import {useEffect, useState} from 'react';


function SalePage() {

    const handleClick = () => {
        console.log("POST");
        sendPost();
    };

    const [items, setItems] = useState([]);

    useEffect(() => {
        getData().then(data => {
            setItems(data);
        })
    }, [setItems]);

    let tbody = <>{items.map(itemData => {
        let date = new Date(itemData.saleDate);
        return (<tr>
            <td>{itemData.id}</td>
            <td>{itemData.products.map(current => (<tr>{current.id} {current.productName}</tr>))}</td>
            <td>{itemData.discountId}</td>
            <td>{date.getDay() + '.' + date.getMonth() + '.' + date.getFullYear()}</td>
        </tr>);
    })}</>;

    return (
        <body className="App-body">
        <div className="container">
            <table className="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>products</th>
                    <th>discountId</th>
                    <th>saleDate</th>
                </tr>
                </thead>
                <tbody id="data">
                {tbody}
                </tbody>
                <tr>
                    <td>
                        <label htmlFor="NewIDSale"/>
                        <input id="NewIDSale" type="text" size="1" placeholder="id"/>
                    </td>
                    <td>
                        <label htmlFor="NewSaleProducts"/>
                        <input id="NewSaleProducts" type="text" size="100" placeholder="products id"/>
                    </td>
                    <td>
                        <label htmlFor="NewSaleDiscountId"/>
                        <input id="NewSaleDiscountId" type="text" size="1"/>
                    </td>
                    <td>
                        <label htmlFor="NewSaleDate"/>
                        <input id="NewSaleDate" type="date" size="25"/>
                    </td>
                </tr>
            </table>
        </div>

        <div>
            <button id="the-button" onClick={handleClick}>
                Add a new sale
            </button>
        </div>
        </body>
    )

    function getData() {
        return fetch("http://localhost:8080/getSales").then((res) => {
            return res.json();
        });
    }

    function sendPost() {
        let payload = {
            id: document.getElementById('NewIDProduct').value,
            productName: document.getElementById('NewProductName').value,
            productPrice: document.getElementById('NewProductPrice').value
        };

        fetch("http://localhost:8080/postSales",
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

export default SalePage;