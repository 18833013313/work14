package bw.com.work14.entity;

public class ProduckXQBean {

    public ResultBean result;
    public String message;
    public String status;

    public static class ResultBean {

        public String categoryId;
        public String categoryName;
        public int commentNum;
        public int commodityId;
        public String commodityName;
        public String describe;
        public String details;
        public String picture;
        public int price;
        public int saleNum;
        public int stock;
        public int weight;

    }
}
