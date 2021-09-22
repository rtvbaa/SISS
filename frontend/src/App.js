import './App.css';

function App() {
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
                        <tbody id="data">
                        </tbody>
                        <tr>
                            <td>id</td>
                            <td>
                                <label htmlFor="NewProductName"/><input id="NewProductName" type="text" size="40"/>
                            </td>
                            <td>
                                <label htmlFor="NewProductPrice"/><input id="NewProductPrice" type="number" size="40"/>
                            </td>
                        </tr>
                    </table>
                </div>
                <div>
                    <button id="the-button" onClick="sendPost()">Add a new product</button>
                </div>
            </header>
        </div>
    );
}

fetch("/get").then(
    res => {
        res.json().then(
            data => {
                console.log(data);
                if (data.length > 0) {

                    var temp = "";
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

function sendPost() {
    let payload = {
        productName: "milk",
        productPrice: 300
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
        .then(function (data) {
            alert(JSON.stringify(data))
            window.location.reload();
        })
}

export default App;
