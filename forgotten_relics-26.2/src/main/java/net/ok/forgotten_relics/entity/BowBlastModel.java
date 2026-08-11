package net.ok.forgotten_relics.entity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.rendertype.RenderType;

public class BowBlastModel extends EntityModel<EntityRenderState> {

	private static final Identifier TEXTURE =
	        Identifier.fromNamespaceAndPath(
	                "forgotten_relics",
	                "textures/entity/bow_blast.png"
	        );

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(
                    Identifier.fromNamespaceAndPath(
                            "forgotten_relics",
                            "bow_blast"
                    ),
                    "main"
            );

    private final ModelPart bone;
    private final ModelPart bb_main;

    public BowBlastModel(ModelPart root) {
        super(root);

        this.bone = root.getChild("bone");
        this.bb_main = root.getChild("bb_main");
    }
    
    public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 26).addBox(-5.0F, 0.0F, -1.0F, 6.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 17.0F, 11.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 26).addBox(-5.0F, 0.0F, -1.0F, 6.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(1, 35).addBox(-0.5F, -7.5F, -14.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(16, 41).addBox(-2.0F, -9.0F, -10.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 41).addBox(-1.0F, -10.0F, -10.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -8.0F, -8.0F, 2.0F, 2.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(28, 41).addBox(-1.5F, -8.5F, -11.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(17, 35).addBox(-1.0F, -7.5F, -13.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(33, 35).addBox(0.0F, -1.0F, -4.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -6.0F, -9.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -7.0F, -9.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public void setupAnim(EntityRenderState state) {
    }

    
}
