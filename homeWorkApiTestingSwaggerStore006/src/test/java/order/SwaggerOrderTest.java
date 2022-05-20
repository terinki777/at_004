package order;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class SwaggerOrderTest {

    @BeforeClass
    private static void setUp() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(Endpoints.host + Endpoints.orderBasePath) // задаём базовый адрес каждого ресурса
                .setAccept(ContentType.JSON) // задаём заголовок accept // приходит
                .setContentType(ContentType.JSON) // задаём заголовок content-type // когда мы отпр
                .log(LogDetail.ALL) // дополнительная инструкция полного логгирования для RestAssured
                .build(); // после этой команды происходит формирование стандартной "шапки" запроса.

        RestAssured.filters(new ResponseLoggingFilter());
    }


    private void createOrder(Order order) {
        given()
                .body(order)
                .when()
                .post(Endpoints.order)
                .then()
                .statusCode(200);
    }


    private void deleteOrder(int id) {
        given().pathParam("id", id)
                .when().delete(Endpoints.order + Endpoints.orderId)
                .then().assertThat().
                statusCode(200);
    }

    private Order getOrder(int id) {
        return given().pathParam("id", id)
                .when().get(Endpoints.order + Endpoints.orderId)
                .then().assertThat().
                        statusCode(200).extract().body().as(Order.class);
    }

    private void getInventory() {
         given()
                .when().get(Endpoints.inventory)
                .then().assertThat().
                        statusCode(200);
    }

    @Test
    private void getInventoryTest(){
        getInventory();
    }

    @Test
    private void createOrderTest() {
        Order order = new SwaggerOrder().dummyOrder();
        createOrder(order);
        Order apiOrder = getOrder(order.getId());
        Assert.assertEquals(order, apiOrder);
    }

    @Test
    private void orderGetTest() {
        Order order = new SwaggerOrder().dummyOrder();
        createOrder(order);
        Order apiOrder = getOrder(order.getId());
        Assert.assertEquals(order, apiOrder);
    }

    @Test
    private void orderDeleteTest() {
        Order order = new SwaggerOrder().dummyOrder();
        createOrder(order);
        deleteOrder(order.getId());
    }
}
