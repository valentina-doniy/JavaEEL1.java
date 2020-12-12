package essence;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

    @SessionScoped
    public class Seller implements Serializable {
        private int sellerId;
        private String sellerName;

        public Seller() {
        }

        public Seller(int sellerId, String sellerName) {
            this.sellerId = sellerId;
            this.sellerName = sellerName;
        }

        public int getSellerId() {
            return sellerId;
        }

        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
        }

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

    }

