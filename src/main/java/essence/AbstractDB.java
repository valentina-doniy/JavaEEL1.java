package essence;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SessionScoped
public class AbstractDB implements Serializable{
    private List<Product> productList;
    private List<Seller> sellerList;
    private List<Sales> salesList;

    public AbstractDB() {
        productList = new ArrayList<>();
        sellerList = new ArrayList<>();
        salesList = new ArrayList<>();

        productList.add(new Product(1, "Диван", 7000));
        productList.add(new Product(2, "Посуд", 300));
        productList.add(new Product(3, "Стіл", 1500));
        productList.add(new Product(4, "Конструктор LEGO", 400));
        productList.add(new Product(5, "Мікрохвильовка", 4000));
        productList.add(new Product(6, "Монітор", 1500));
        productList.add(new Product(7, "Парфюм", 1000));

        sellerList.add(new Seller(1, "Ткачук Софія"));
        sellerList.add(new Seller(2, "Панова Ангеліна"));
        sellerList.add(new Seller(3, "Даценко Марина"));
        sellerList.add(new Seller(4, "Вітковський Степан"));
        sellerList.add(new Seller(5, "Михальчук Аліна"));
        sellerList.add(new Seller(6, "Клименко Дмитро"));
        sellerList.add(new Seller(7, "Коновалова Маргарита"));

        salesList.add(new Sales(1, 3, 2, 15));
        salesList.add(new Sales(2, 4, 1, 200));
        salesList.add(new Sales(3, 5, 3, 10));
        salesList.add(new Sales(4, 7, 5, 100));
        salesList.add(new Sales(5, 6, 4, 30));
        salesList.add(new Sales(6, 2, 6, 30));
        salesList.add(new Sales(7, 1, 7, 15));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<Seller> getSellerList() {
        return sellerList;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }
}
