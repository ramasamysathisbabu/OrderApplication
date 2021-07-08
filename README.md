# OrderApplication

Step1 API Details:

URL: http://localhost:8080/orders

Request Payload:
```json
{

    "orderLineItems" : [
        {
            "productId" : 1,
            "productName": "Apple",
            "quantity" : 5,
            "price" : 0.60,
            "offer" : "BOGO"
        },
        {
            "productId" : 2,
            "productName": "Orange",
            "quantity" : 2,
            "price" : 0.25,
            "offer" : "3FOR2"
        }
    ]
}
```