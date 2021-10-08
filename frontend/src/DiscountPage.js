import {useEffect, useState} from 'react';

function DiscountPage() {

    const [items, setItems] = useState([]);

    useEffect(() => {
        getData().then(data => {
            setItems(data);
        })
    }, [setItems]);

    let map = items.map(itemData => (<tr>
        <td>{itemData.id}</td>
        <td>{itemData.discountPercentage}</td>
        <td>{new Date(itemData.discountDate).getHours()}</td>
        <td>{itemData.productId}</td>
    </tr>));

    return (
        <body className="App-body">
        <div className="container">
            <table className="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Percentage</th>
                    <th>Discount hour</th>
                    <th>Product Id</th>
                </tr>
                </thead>
                <tbody id="data">
                {map}
                </tbody>
            </table>
        </div>
        </body>
    )

    function getData() {
        return fetch("http://localhost:8080/getDiscount").then((res) => {
            return res.json();
        });
    }

}

export default DiscountPage;