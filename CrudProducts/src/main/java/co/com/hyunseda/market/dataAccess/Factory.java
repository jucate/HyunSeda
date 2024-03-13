package co.com.hyunseda.market.dataAccess;

public class Factory {
    private static Factory instance;

    private Factory(){

    }

    public static Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public IProductRepository getRepository(String type) {

        IProductRepository result = null;

        switch (type) {
            case "default":
                result = new ProductRepository();
                break;
        }

        return result;

    }
    public ICategoryRepository getRepositoryCategory(String type){
        ICategoryRepository result = null;
        switch (type) {
            case "default":
                result = new CategoryRepository();
                break;
        }

        return result;
    }
}
