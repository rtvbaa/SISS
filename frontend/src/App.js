import "./App.css";

function App() {
    const handleClick = () => {
        console.log("POST");
        sendPost();
    };

    return (
        <div className="App">
            <header className="App-header">
                <div className="container">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Product name</th>
                            <th>Product price</th>
                        </tr>
                        </thead>
                        <tbody id="data">{get()}</tbody>
                        <tr>
                            <td>id</td>
                            <td>
                                <label htmlFor="NewProductName"/>
                                <input id="NewProductName" type="text" size="40"/>
                            </td>
                            <td>
                                <label htmlFor="NewProductPrice"/>
                                <input id="NewProductPrice" type="number" size="40"/>
                            </td>
                        </tr>
                    </table>
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

function get() {
    fetch("/get").then(
        res => {
            res.json().then(
                data => {
                    console.log(data);
                    if (data.length > 0) {
                        let temp = "";
                        data.forEach((itemData) => {
                            temp += "<tr>";
                            temp += "<td>" + itemData.id + "</td>";
                            temp += "<td>" + itemData.productName + "</td>";
                            temp += "<td>" + itemData.productPrice + "</td></tr>";
                        });
                        document.getElementById('data').innerHTML = temp;
                    }
                }
            )
        }
    )

}

function sendPost() {
    let payload = {
        productName: document.getElementById('NewProductName').value,
        productPrice: document.getElementById('NewProductPrice').value
    };

    fetch("/post",
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
