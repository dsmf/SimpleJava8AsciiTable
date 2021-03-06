import java.math.BigDecimal;

public class ExampleRecord {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExampleRecord(String description, String materialNo, BigDecimal totalQuantity, String unit,
            BigDecimal unitPrice) {
        super();
        this.description = description;
        this.materialNo = materialNo;
        this.totalQuantity = totalQuantity;
        this.unit = unit;
        this.unitPrice = unitPrice;
    }

    private String materialNo;

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }
    
    private BigDecimal totalQuantity;
    
    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }
    
    public void setTotalQuantity(BigDecimal totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    
    private String unit;
    
    public String getUnit() {
        return unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    private BigDecimal unitPrice;
    
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    

}
