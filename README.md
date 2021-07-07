# OrderApplication

Step1 API Details:

URL: http://localhost:8080/orders

Request Payload:
```json
{
    "orderNumber" : 1,
    "orderLineItems" : [
        {
            "productId" : 1,
            "productName": "Apple",
            "quantity" : 1,
            "price" : 0.60
        },
        {
            "productId" : 2,
            "productName": "Orange",
            "quantity" : 3,
            "price" : 0.25
        }
    ]
}
```