package net.ok.forgotten_relics.entity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BowBlastModel extends EntityModel<BowBlastRenderState> {

    private final ModelPart bb_main;

    public BowBlastModel(ModelPart root) {
        super(root);
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",CubeListBuilder.create(),net.minecraft.client.model.geom.PartPose.offset(0.0F, 12.0F, 0.0F));
       
        
        
        bb_main.addOrReplaceChild("cube_r1",CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, 1.0F, -14.0F, 18.0F, 0.0F, 32.0F,new CubeDeformation(0.0F)),net.minecraft.client.model.geom.PartPose.offsetAndRotation(0.0F, -13.0F, -1.0F, -1.5708F, 0.0F, 1.5708F));

        bb_main.addOrReplaceChild("cube_r2",CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, -15.0F, 18.0F, 0.0F, 32.0F,new CubeDeformation(0.0F)),net.minecraft.client.model.geom.PartPose.offsetAndRotation(0.0F, -13.0F, -1.0F, 0.0F, 1.5708F, -3.1416F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(BowBlastRenderState state) {
        super.setupAnim(state);
    }
}