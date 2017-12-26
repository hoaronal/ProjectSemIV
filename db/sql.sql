/*
Navicat SQL Server Data Transfer

Source Server         : SqlServerLocal
Source Server Version : 120000
Source Host           : localhost:1433
Source Database       : shop_online
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 120000
File Encoding         : 65001

Date: 2017-12-23 18:51:35
*/


-- ----------------------------
-- Table structure for accessories
-- ----------------------------
CREATE TABLE [accessories] (
[id] int NOT NULL IDENTITY(1,1) ,
[name] nvarchar(255) NULL ,
[detail] nvarchar(255) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL 
)

CREATE TABLE [admin] (
[id] int NOT NULL IDENTITY(1,1) ,
[account] nvarchar(50) NOT NULL ,
[password] nvarchar(50) NOT NULL ,
[email] nvarchar(255) NOT NULL ,
[phone] nvarchar(20) NULL ,
[birthday] datetime NULL ,
[address] nvarchar(100) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL ,
[active_status] tinyint NOT NULL ,
[status] tinyint NOT NULL 
)
CREATE TABLE [category] (
[id] int NOT NULL IDENTITY(1,1) ,
[name_category] nvarchar(255) NOT NULL ,
[description] text NULL ,
[parent_id] int NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL 
)
CREATE TABLE [gift] (
[id] int NOT NULL IDENTITY(1,1) ,
[name] nvarchar(100) NOT NULL ,
[description] nvarchar(255) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL 
)
CREATE TABLE [group_role] (
[id] int NOT NULL IDENTITY(1,1) ,
[group_role_name] nvarchar(100) NOT NULL ,
[description] nvarchar(255) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL ,
[guarantee_from] datetime NULL ,
[guarantee_to] datetime NULL ,
[serial] varchar(255) NULL 
)

CREATE TABLE [guarantee] (
[id] int NOT NULL IDENTITY(1,1) ,
[serial] nvarchar(100) NOT NULL ,
[guarantee_from] datetime NULL ,
[guarantee_to] datetime NULL 
)

CREATE TABLE [history_action] (
[id] int NOT NULL IDENTITY(1,1) ,
[admin_id] int NOT NULL ,
[client_info] nvarchar(255) NOT NULL ,
[access_type] nvarchar(10) NOT NULL ,
[execute_date] datetime NOT NULL ,
[description] nvarchar(255) NOT NULL 
)

CREATE TABLE [news] (
[id] int NOT NULL IDENTITY(1,1) ,
[title] nvarchar(255) NOT NULL ,
[description] nvarchar(255) NULL ,
[image_link] nvarchar(255) NULL ,
[image_list] nvarchar(255) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL 
)


CREATE TABLE [order] (
[id] int NOT NULL IDENTITY(1,1) ,
[qty] int NOT NULL ,
[amount] float(53) NOT NULL ,
[data] nchar(10) NULL ,
[status] tinyint NOT NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL ,
[product_id] int NOT NULL ,
[transaction_id] int NOT NULL 
)


CREATE TABLE [product] (
[id] int NOT NULL IDENTITY(1,1) ,
[product_name] nvarchar(255) NOT NULL ,
[price] float(53) NOT NULL ,
[discount] float(53) NOT NULL ,
[category_id] int NULL ,
[image_link] nvarchar(255) NULL ,
[image_list] nvarchar(255) NULL ,
[count_view] float(53) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL ,
[detail] nvarchar(255) NULL ,
[status] tinyint NOT NULL 
)


CREATE TABLE [product_gift] (
[id] int NOT NULL IDENTITY(1,1) ,
[product_id] int NOT NULL ,
[gift_id] int NOT NULL ,
[description] nvarchar(255) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL 
)


CREATE TABLE [province] (
[id] int NOT NULL IDENTITY(1,1) ,
[province_name] nvarchar(100) NOT NULL ,
[description] nvarchar(255) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL ,
[code] varchar(255) NOT NULL 
)


CREATE TABLE [role] (
[id] int NOT NULL IDENTITY(1,1) ,
[role_name] nvarchar(50) NOT NULL ,
[description] nvarchar(500) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL 
)

CREATE TABLE [role_by_group_role] (
[id] int NOT NULL IDENTITY(1,1) ,
[role_id] int NOT NULL ,
[group_role_id] int NOT NULL 
)

CREATE TABLE [transaction] (
[id] int NOT NULL ,
[user_id] int NOT NULL ,
[user_name] nvarchar(50) NOT NULL ,
[user_email] nvarchar(255) NOT NULL ,
[user_phone] nvarchar(20) NOT NULL ,
[amount] float(53) NOT NULL ,
[payment] nvarchar(255) NOT NULL ,
[payment_info] nvarchar(255) NULL ,
[message] nvarchar(255) NULL ,
[security] nvarchar(50) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL 
)

CREATE TABLE [users] (
[id] int NOT NULL IDENTITY(1,1) ,
[username] nvarchar(50) NOT NULL ,
[password] nvarchar(50) NOT NULL ,
[email] nvarchar(50) NOT NULL ,
[phone] nvarchar(20) NULL ,
[birthday] datetime NULL ,
[address] nvarchar(255) NULL ,
[admin_create] int NULL ,
[admin_update] int NULL ,
[create_date] datetime NULL ,
[update_date] datetime NULL ,
[active_status] tinyint NOT NULL ,
[status] tinyint NOT NULL 
)

-- ----------------------------
-- Primary Key structure for table accessories
-- ----------------------------
ALTER TABLE [accessories] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table admin
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table admin
-- ----------------------------
ALTER TABLE [admin] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table category
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table category
-- ----------------------------
ALTER TABLE [category] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table gift
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table gift
-- ----------------------------
ALTER TABLE [gift] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table group_role
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table group_role
-- ----------------------------
ALTER TABLE [group_role] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table guarantee
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table guarantee
-- ----------------------------
ALTER TABLE [guarantee] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table history_action
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table history_action
-- ----------------------------
ALTER TABLE [history_action] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table news
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table news
-- ----------------------------
ALTER TABLE [news] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table order
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table order
-- ----------------------------
ALTER TABLE [order] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table product
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table product
-- ----------------------------
ALTER TABLE [product] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table product_gift
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table product_gift
-- ----------------------------
ALTER TABLE [product_gift] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table province
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table province
-- ----------------------------
ALTER TABLE [province] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table role
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table role
-- ----------------------------
ALTER TABLE [role] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table role_by_group_role
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table role_by_group_role
-- ----------------------------
ALTER TABLE [role_by_group_role] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table transaction
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table transaction
-- ----------------------------
ALTER TABLE [transaction] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table users
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE [users] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Foreign Key structure for table [category]
-- ----------------------------
ALTER TABLE [category] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [category] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [category] ADD FOREIGN KEY ([parent_id]) REFERENCES [category] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [gift]
-- ----------------------------
ALTER TABLE [gift] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [gift] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [group_role]
-- ----------------------------
ALTER TABLE [group_role] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [group_role] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [history_action]
-- ----------------------------
ALTER TABLE [history_action] ADD FOREIGN KEY ([admin_id]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [news]
-- ----------------------------
ALTER TABLE [news] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [news] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [order]
-- ----------------------------
ALTER TABLE [order] ADD FOREIGN KEY ([product_id]) REFERENCES [product] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [order] ADD FOREIGN KEY ([transaction_id]) REFERENCES [transaction] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [order] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [order] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [product]
-- ----------------------------
ALTER TABLE [product] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [product] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [product] ADD FOREIGN KEY ([category_id]) REFERENCES [category] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [product_gift]
-- ----------------------------
ALTER TABLE [product_gift] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [product_gift] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [product_gift] ADD FOREIGN KEY ([gift_id]) REFERENCES [gift] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [product_gift] ADD FOREIGN KEY ([product_id]) REFERENCES [product] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [province]
-- ----------------------------
ALTER TABLE [province] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [province] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [role]
-- ----------------------------
ALTER TABLE [role] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [role] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [role_by_group_role]
-- ----------------------------
ALTER TABLE [role_by_group_role] ADD FOREIGN KEY ([group_role_id]) REFERENCES [group_role] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [role_by_group_role] ADD FOREIGN KEY ([role_id]) REFERENCES [role] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [transaction]
-- ----------------------------
ALTER TABLE [transaction] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [transaction] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [users]
-- ----------------------------
ALTER TABLE [users] ADD FOREIGN KEY ([admin_create]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [users] ADD FOREIGN KEY ([admin_update]) REFERENCES [admin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
