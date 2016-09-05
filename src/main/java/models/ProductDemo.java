package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productDemoo")
public class ProductDemo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "gender")
    private String gender;

    @Column(name = "movement")
    private String movement;

    @Column(name = "watchlabel")
    private String watchLabel;

    @Column(name = "casesize")
    private double caseSize;

    @Column(name = "casethickness")
    private double caseThickness;

    @Column(name = "casematerial")
    private String caseMaterial;

    @Column(name = "caseshape")
    private String caseShape;

    @Column(name = "dialtype")
    private String dialType;

    @Column(name = "dialcolor")
    private String dialColor;

    @Column(name = "crystal")
    private String crystal;

    @Column(name = "waterresistance")
    private String waterResistance;

    @Column(name = "metal")
    private String metal;

    @Column(name = "clasp")
    private String clasp;

    @Column(name = "chainlength")
    private double chainLength;

    @Column(name = "chaintype")
    private String chainType;

    @Column(name = "width")
    private double width;

    @Column(name = "length")
    private double length;

    @Column(name = "rhodiumplated")
    private String rhodiumPlated;

    @Column(name = "numberofcenterrounddiamonds")
    private int numberOfCenterRoundDiamonds;

    @Column(name = "minimumcarattotalweight")
    private double minimumCaratTotalWeight;

    @Column(name = "minimumcolor")
    private String minimumColor;

    @Column(name = "minimumclarity")
    private String minimumClarity;

    @Column(name = "minimumcut")
    private String minimumCut;

    @Column(name = "settingtype")
    private String settingType;

    @Column(name = "price")
    private double price;
    
    @Column(name = "path")
    private String path;

    public ProductDemo() {

    }

    //for count data size
    public ProductDemo(int id, double price)
    {
        this.id = id;
        this.price = price;
    }
    
    
    // watch contructor
    public ProductDemo(String name, String type, String brand, String model, String gender, String movement,
        String watchlabel, double caseSize, double caseThickness, String caseMaterial, String caseShape, String dialType, String dialColor,
        String crystal, String waterResistance, double price, String path) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.gender = gender;
        this.movement = movement;
        this.watchLabel = watchlabel;
        this.caseSize = caseSize;
        this.caseThickness = caseThickness;
        this.caseMaterial = caseMaterial;
        this.caseShape = caseShape;
        this.dialType = dialType;
        this.dialColor = dialColor;
        this.crystal = crystal;
        this.waterResistance = waterResistance;
        this.price = price;
        this.path = path;
    }

    // jewelry contructor
    public ProductDemo(String name, String type, String metal, String clasp, double chainLength, String chainType,
        double width, double length, String rhodiumPlated, int numberOfCenterRoundDiamonds,
        double minimumCaratTotalWeight, String minimumColor, String minimumClarity, String minimumCut,
        String settingType, double price, String path) {
        this.name = name;
        this.type = type;
        this.metal = metal;
        this.clasp = clasp;
        this.chainLength = chainLength;
        this.chainType = chainType;
        this.width = width;
        this.length = length;
        this.rhodiumPlated = rhodiumPlated;
        this.numberOfCenterRoundDiamonds = numberOfCenterRoundDiamonds;
        this.minimumCaratTotalWeight = minimumCaratTotalWeight;
        this.minimumColor = minimumColor;
        this.minimumClarity = minimumClarity;
        this.minimumCut = minimumCut;
        this.settingType = settingType;
        this.price = price;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getWatchLabel() {
        return watchLabel;
    }

    public void setWatchLabel(String watchLabel) {
        this.watchLabel = watchLabel;
    }

    public double getCaseSize() {
        return caseSize;
    }

    public void setCaseSize(double caseSize) {
        this.caseSize = caseSize;
    }

    public double getCaseThickness() {
        return caseThickness;
    }

    public void setCaseThickness(double caseThickness) {
        this.caseThickness = caseThickness;
    }

    public String getCaseMaterial() {
        return caseMaterial;
    }

    public void setCaseMaterial(String caseMaterial) {
        this.caseMaterial = caseMaterial;
    }

    public String getCaseShape() {
        return caseShape;
    }

    public void setCaseShape(String caseShape) {
        this.caseShape = caseShape;
    }

    public String getDialType() {
        return dialType;
    }

    public void setDialType(String dialType) {
        this.dialType = dialType;
    }

    public String getDialColor() {
        return dialColor;
    }

    public void setDialColor(String dialColor) {
        this.dialColor = dialColor;
    }

    public String getCrystal() {
        return crystal;
    }

    public void setCrystal(String crystal) {
        this.crystal = crystal;
    }

    public String getWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(String waterResistance) {
        this.waterResistance = waterResistance;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getClasp() {
        return clasp;
    }

    public void setClasp(String clasp) {
        this.clasp = clasp;
    }

    public double getChainLength() {
        return chainLength;
    }

    public void setChainLength(double chainLength) {
        this.chainLength = chainLength;
    }

    public String getChainType() {
        return chainType;
    }

    public void setChainType(String chainType) {
        this.chainType = chainType;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getRhodiumPlated() {
        return rhodiumPlated;
    }

    public void setRhodiumPlated(String rhodiumPlated) {
        this.rhodiumPlated = rhodiumPlated;
    }

    public int getNumberOfCenterRoundDiamonds() {
        return numberOfCenterRoundDiamonds;
    }

    public void setNumberOfCenterRoundDiamonds(int numberOfCenterRoundDiamonds) {
        this.numberOfCenterRoundDiamonds = numberOfCenterRoundDiamonds;
    }

    public double getMinimumCaratTotalWeight() {
        return minimumCaratTotalWeight;
    }

    public void setMinimumCaratTotalWeight(double minimumCaratTotalWeight) {
        this.minimumCaratTotalWeight = minimumCaratTotalWeight;
    }

    public String getMinimumColor() {
        return minimumColor;
    }

    public void setMinimumColor(String minimumColor) {
        this.minimumColor = minimumColor;
    }

    public String getMinimumClarity() {
        return minimumClarity;
    }

    public void setMinimumClarity(String minimumClarity) {
        this.minimumClarity = minimumClarity;
    }

    public String getMinimumCut() {
        return minimumCut;
    }

    public void setMinimumCut(String minimumCut) {
        this.minimumCut = minimumCut;
    }

    public String getSettingType() {
        return settingType;
    }

    public void setSettingType(String settingType) {
        this.settingType = settingType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}
