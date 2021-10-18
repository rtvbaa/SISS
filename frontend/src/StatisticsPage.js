import {useEffect, useState} from "react";

function getData() {
    return fetch("http://localhost:8080/getHourlyStatistics").then((res) => {
        return res.json();
    })
}

function StatisticsPage() {

    const [items, setItems] = useState([]);

    useEffect(() => {
        getData().then(data => {
            setItems(data);
        })
    }, [setItems]);

    let map = items.map(itemData => (<tr>
        <td>{new Date(itemData.statisticsDate).getHours()}</td>
        <td>{itemData.numberOfReceipts}</td>
        <td>{itemData.totalCostOfReceipts}</td>
        <td>{itemData.theCostOfAnAverageCheck}</td>
        <td>{itemData.theAmountOfDiscounts}</td>
        <td>{itemData.theTotalCostOfReceiptsIncludingDiscounts}</td>
        <td>{itemData.theCostOfAnAverageReceiptIncludingDiscounts}</td>
        <td>{itemData.theIncreaseInTheAverageCheckToThePreviousHour}</td>
    </tr>));

    return (
        <body className="App-body">
        <div className="container">
            <table className="table">
                <thead>
                <tr>
                    <th>Hour</th>
                    <th>Number of receipts</th>
                    <th>Total cost of receipts</th>
                    <th>The cost of an average check</th>
                    <th>The amount of discounts</th>
                    <th>The total cost of receipts, including discounts</th>
                    <th>The cost of an average receipt, including discounts</th>
                    <th>The increase in the average check to the previous hour</th>
                </tr>
                </thead>
                <tbody id="data">
                {map}
                </tbody>
            </table>
        </div>
        </body>
    );
}

export default StatisticsPage;