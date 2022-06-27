package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DIGITAL_ASSET")
@Getter
@Setter
public class DigitalAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIGITAL_ASSET_ID", nullable = false)
    private Integer digitalAssetId;

    @Column(name = "MEDIA_TYPE", length = 45)
    private String mediaType;

    @Column(name = "ASSET_TITLE", length = 45)
    private String assetTitle;

    @Column(name = "ASSET_DESCRIPTION", length = 145)
    private String assetDescription;

    @Column(name = "ASSET_STORAGE_LOCATION", length = 145)
    private String assetStorageLocation;


}
