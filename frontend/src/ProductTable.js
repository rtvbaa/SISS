function ProductTable(props) {
   return  (<table className="table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Product name</th>
                            <th>Product price</th>
                        </tr>
                        </thead>
                        <tbody id="data">
                            {props.items.map(itemData => (<tr><td>{itemData.id}</td><td>{itemData.productName}</td><td>{itemData.productPrice}</td></tr>))} 
                        </tbody>
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
                    </table>)
}

export default ProductTable;