package cl.eduardo.productsservice.dto;

import java.util.ArrayList;
import java.util.List;

public class SimilarIdsDto {
    private List<Long> ids;

    public SimilarIdsDto() {
        ids = new ArrayList<>();
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
