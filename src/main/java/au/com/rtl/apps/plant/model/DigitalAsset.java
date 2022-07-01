package au.com.rtl.apps.plant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DIGITAL_ASSET")
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
    
    @Column(name = "ASSET_DATA")
    @Lob
    private byte[] assetData;

	public Integer getDigitalAssetId() {
		return digitalAssetId;
	}

	public void setDigitalAssetId(Integer digitalAssetId) {
		this.digitalAssetId = digitalAssetId;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getAssetTitle() {
		return assetTitle;
	}

	public void setAssetTitle(String assetTitle) {
		this.assetTitle = assetTitle;
	}

	public String getAssetDescription() {
		return assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public String getAssetStorageLocation() {
		return assetStorageLocation;
	}

	public void setAssetStorageLocation(String assetStorageLocation) {
		this.assetStorageLocation = assetStorageLocation;
	}

	public byte[] getAssetData() {
		return assetData;
	}

	public void setAssetData(byte[] assetData) {
		this.assetData = assetData;
	}
    
    


}
