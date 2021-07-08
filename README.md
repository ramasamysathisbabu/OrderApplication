# OrderApplication

Step1: POST order Summary API endpoint and payload

URL: http://localhost:8080/orders

Http Method: POST

Request Payload:
```json
{

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
            "quantity" : 1,
            "price" : 0.25
        }
    ]
}
```



Step2: applying offers for the order.
URL: http://localhost:8080/orders

Http Method: POST

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


Step3(1): GET single order details

URL: http://localhost:8080/orders/{orderId} 
	Please replace orederId with integer value. Eg: http://localhost:8080/orders/1
	
Http Method: GET


Step3(2): GET All order details

URL: http://localhost:8080/orders
	
Http Method: GET

